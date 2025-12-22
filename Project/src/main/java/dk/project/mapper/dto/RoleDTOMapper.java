// Package
package dk.project.mapper.dto;

// Imports
import dk.project.dto.RoleCreateDTO;
import dk.project.dto.RoleResponseDTO;
import dk.project.entity.Role;

public class RoleDTOMapper {

    public static Role toEntity(RoleCreateDTO dto) {
        return new Role(
                dto.getName()
        );
    }

    public static RoleResponseDTO toResponseDTO(Role role) {
        return new RoleResponseDTO(
                role.getId(),
                role.getName()
        );
    }

}