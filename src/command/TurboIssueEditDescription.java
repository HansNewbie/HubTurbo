package command;

import java.io.IOException;

import service.ServiceManager;
import model.Model;
import model.TurboIssue;

public class TurboIssueEditDescription extends TurboIssueCommand{
	String newDescription;

	public TurboIssueEditDescription(Model model, TurboIssue issue, String description){
		super(model, issue);
		newDescription = description;
	}
	
	@Override
	public boolean execute() {
		String oldDescription = issue.getDescription();
		isSuccessful = editIssueDescription(oldDescription, newDescription);
		return isSuccessful;
	}
	
	private boolean editIssueDescription(String oldDesc, String newDesc){
		issue.setDescription(newDesc);
		try {
			ServiceManager service = ServiceManager.getInstance();
			service.editIssueBody(issue.getId(), issue.buildGithubBody());
			service.logIssueChanges(issue.getId(), DESCRIPTION_CHANGE_LOG);
			return true;
		} catch (IOException e) {
			issue.setDescription(oldDesc);
			return false;
		}
	}

	@Override
	public boolean undo() {
		return true;
	}

}
