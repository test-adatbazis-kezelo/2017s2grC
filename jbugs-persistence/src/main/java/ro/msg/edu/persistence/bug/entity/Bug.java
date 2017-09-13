package ro.msg.edu.persistence.bug.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import ro.msg.edu.persistence.bug.entity.enums.BugSeverityType;
import ro.msg.edu.persistence.bug.entity.enums.BugStatusType;
import ro.msg.edu.persistence.common.entity.AbstractEntity;
import ro.msg.edu.persistence.notification.entity.Notification;
import ro.msg.edu.persistence.user.entity.User;

@Entity
public class Bug extends AbstractEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idBug;

	@NotNull
	@Column
	private String titleBug;

	@NotNull
	@Size(min = 250)
	@Column
	private String descriptionBug;

	@NotNull
	@Column
	private String version;

	@Column
	private String versionFixed;

	@Future
	@Column
	private String targetDate;

	@NotNull
	@Column
	@Enumerated(EnumType.STRING)
	private BugSeverityType severity;

	@NotNull
	@ManyToOne
	private User createdBy;

	@Column
	@Enumerated(EnumType.STRING)
	private BugStatusType status;

	@ManyToOne
	private User assignedTo;

	@OneToMany(mappedBy = "bug")
	private List<Attachment> attachments;

	@OneToMany(mappedBy = "bug")
	private List<Notification> notifications;

	@OneToMany(mappedBy = "bug")
	private List<History> history;

	@Override
	public Long getId() {
		return idBug;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getTitleBug() {
		return titleBug;
	}

	public void setTitleBug(String titleBug) {
		this.titleBug = titleBug;
	}

	public String getDescriptionBug() {
		return descriptionBug;
	}

	public void setDescriptionBug(String descriptionBug) {
		this.descriptionBug = descriptionBug;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getVersionFixed() {
		return versionFixed;
	}

	public void setVersionFixed(String versionFixed) {
		this.versionFixed = versionFixed;
	}

	public String getTargetDate() {
		return targetDate;
	}

	public void setTargetDate(String targetDate) {
		this.targetDate = targetDate;
	}

	public BugSeverityType getSeverity() {
		return severity;
	}

	public void setSeverity(BugSeverityType severity) {
		this.severity = severity;
	}

	public User getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(User createdBy) {
		this.createdBy = createdBy;
	}

	public BugStatusType getStatus() {
		return status;
	}

	public void setStatus(BugStatusType status) {
		this.status = status;
	}

	public User getAssignedTo() {
		return assignedTo;
	}

	public void setAssignedTo(User assignedTo) {
		this.assignedTo = assignedTo;
	}

	public List<Attachment> getAttachments() {
		return attachments;
	}

	public void setAttachments(List<Attachment> attachments) {
		this.attachments = attachments;
	}

	public List<Notification> getNotifications() {
		return notifications;
	}

	public void setNotifications(List<Notification> notifications) {
		this.notifications = notifications;
	}

	public List<History> getHistory() {
		return history;
	}

	public void setHistory(List<History> history) {
		this.history = history;
	}

	@Override
	public String toString() {
		return "Bug [idBug=" + idBug + ", titleBug=" + titleBug + ", createdBy=" + createdBy + ", status=" + status
				+ ", assignedTo=" + assignedTo + "]";
	}

}
