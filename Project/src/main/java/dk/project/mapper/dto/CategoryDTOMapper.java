// Package
package dk.project.mapper.dto;

// Imports
import dk.project.dto.CategoryCreateDTO;
import dk.project.dto.CategoryResponseDTO;
import dk.project.entity.Category;

public class CategoryDTOMapper {

    // Attributes

    // _______________________________________________________

    public static Category toEntity(CategoryCreateDTO dto) {
        return new Category(
                dto.getName(),
                dto.getDescription()
        );
    }

    // _______________________________________________________

    public static CategoryResponseDTO toResponseDTO(Category category) {
        return new CategoryResponseDTO(
                category.getId(),
                category.getName(),
                category.getDescription()
        );
    }

}