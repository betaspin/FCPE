package fr.imie.fcpe.mapping;

import fr.imie.fcpe.RoleEntity;
import fr.imie.fcpe.model.RoleBO;

public class RoleMapping {

    public static RoleBO mapRoleEntityToBO(RoleEntity roleEntity){
        RoleBO roleBO = new RoleBO();
        roleBO.setId(roleEntity.getId());
        roleBO.setLabel(roleEntity.getLabel());
        return roleBO;
    }

    public static RoleEntity mapRoleBOToEntity(RoleBO roleBO){
    	RoleEntity roleEntity = new RoleEntity();
        roleEntity.setId(roleBO.getId());
        roleEntity.setLabel(roleBO.getLabel());
        return roleEntity;
    }

}
