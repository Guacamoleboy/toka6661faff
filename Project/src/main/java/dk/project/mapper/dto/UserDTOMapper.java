// Package
package dk.project.mapper.dto;

// Imports
import dk.project.dto.UserCreateDTO;
import dk.project.dto.UserResponseDTO;
import dk.project.entity.User;

public class UserDTOMapper {

    // Attributes

    // __________________________________________________________________

    public static User toEntity(UserCreateDTO dto, String usernameHashed, String emailHashed, String passwordHash, int roleId) {
        return new User(
                usernameHashed,
                emailHashed,
                passwordHash,
                roleId
        );
    }

    // __________________________________________________________________

    public static UserResponseDTO toResponseDTO(User user, String roleName) {
        return new UserResponseDTO(
                user.getId(),
                user.getUsernameHashed(),
                roleName
        );
    }

}