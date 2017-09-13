package ro.msg.edu.persistence.user.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;

import ro.msg.edu.persistence.common.entity.AbstractEntity;
import ro.msg.edu.persistence.user.entity.enums.PermissionType;

@Entity
public class Permission extends AbstractEntity {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idPermission;

	@NotNull
	@Column
	@Enumerated(EnumType.STRING)
	private PermissionType namePermission;

	@Column
	private String detailPermission;

	@ManyToMany(mappedBy = "permissions")
	private List<Role> roles;

	@Override
	public Long getId() {
		return idPermission;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public PermissionType getNamePermission() {
		return namePermission;
	}

	public void setNamePermission(PermissionType namePermission) {
		this.namePermission = namePermission;
	}

	public String getDetailPermission() {
		return detailPermission;
	}

	public void setDetailPermission(String detailPermission) {
		this.detailPermission = detailPermission;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	@Override
	public String toString() {
		return "Permission [idPermission=" + idPermission + ", namePermission=" + namePermission + "]";
	}

}
