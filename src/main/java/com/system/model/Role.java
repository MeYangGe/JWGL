package com.system.model;





import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;
@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class Role implements Serializable{
    @NonNull
    private Integer rid;
    private String roleName;
    private String permissions;


    /*public Role(Integer rid) {
        this.rid = rid;
    }

    public Role(Integer rid, String roleName, String permissions) {
        this.rid = rid;
        this.roleName = roleName;
        this.permissions = permissions;
    }

    public Role() {
    }*/

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getPermissions() {
        return permissions;
    }

    public void setPermissions(String permissions) {
        this.permissions = permissions;
    }
}
