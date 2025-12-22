package dk.project.mapper.dto;

import dk.project.dto.ProductCreateDTO;
import dk.project.dto.ProductResponseDTO;
import dk.project.entity.Product;

public class ProductDTOMapper {

    public static Product toEntity(ProductCreateDTO dto) {
        return new Product(
                dto.getBarcode(),
                dto.getTitle(),
                dto.getProductInfoId(),
                dto.getCategoryId()
        );
    }

    public static ProductResponseDTO toResponseDTO(Product product,
                                                   String categoryName,
                                                   String description) {
        return new ProductResponseDTO(
                product.getBarcode(),
                product.getTitle(),
                categoryName,
                description
        );
    }

}