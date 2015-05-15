package backend.resource.serialization;

import backend.resource.TurboMilestone;

import java.time.LocalDate;
import java.util.Optional;

public class SerializableMilestone {
	public final int id;
	public final String title;
	public final Optional<LocalDate> dueDate;
	public final String description;
	public final boolean isOpen;
	public final int openIssues;
	public final int closedIssues;

	public SerializableMilestone(TurboMilestone milestone) {
		this.id = milestone.getId();
		this.title = milestone.getTitle();
		this.dueDate = milestone.getDueDate();
		this.description = milestone.getDescription();
		this.isOpen = milestone.isOpen();
		this.openIssues = milestone.getOpenIssues();
		this.closedIssues = milestone.getClosedIssues();
	}
}
