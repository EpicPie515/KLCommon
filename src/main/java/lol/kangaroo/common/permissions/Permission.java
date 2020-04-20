package lol.kangaroo.common.permissions;

public class Permission implements IGrantable {
	
	private String permissionStr;
	private boolean permissionValue;
	
	public Permission(String permission) {
		if(permission.startsWith("-")) {
			this.permissionStr = permission.substring(1);
			this.permissionValue = false;
		} else {
			this.permissionStr = permission;
			this.permissionValue = true;
		}
	}

	public Permission(String permission, boolean permissionValue) {
		if(permission.startsWith("-"))
			this.permissionStr = permission.substring(1);
		else
			this.permissionStr = permission;
		this.permissionValue = permissionValue;
	}

	public boolean getPermissionValue() {
		return permissionValue;
	}

	public void setPermissionValue(boolean permissionValue) {
		this.permissionValue = permissionValue;
	}

	public String getPermission() {
		return permissionStr;
	}
	
	@Override
	public String toString() {
		return (permissionValue ? "" : "-") + permissionStr;
	}
	
	
}
