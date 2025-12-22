// Package
package dk.project.mapper.dto;

// Imports
import dk.project.dto.ProductInfoCreateDTO;
import dk.project.dto.ProductInfoResponseDTO;
import dk.project.entity.ProductInfo;

public class ProductInfoDTOMapper {

    // Attributes

    // _______________________________________________________________

    public static ProductInfo toEntity(ProductInfoCreateDTO dto) {
        return new ProductInfo(
                dto.getName(),
                dto.getDescription()
        );
    }

    // _______________________________________________________________

    public static ProductInfoResponseDTO toResponseDTO(ProductInfo productInfo) {
        return new ProductInfoResponseDTO(
                productInfo.getId(),
                productInfo.getName(),
                productInfo.getDescription()
        );
    }

}