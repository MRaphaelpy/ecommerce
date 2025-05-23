package com.mraphael.CallOfSweets.Impl;

import com.mraphael.CallOfSweets.Entities.ProductVariation;
import com.mraphael.CallOfSweets.Repositories.ProductVariationRepository;
import com.mraphael.CallOfSweets.Services.ProductVariationService;
import com.mraphael.CallOfSweets.DTOs.ProductVariationDTO;
import com.mraphael.CallOfSweets.Mappers.ProductVariationMapper;
import com.mraphael.CallOfSweets.Exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductVariationServiceImpl implements ProductVariationService {

    @Autowired
    private ProductVariationRepository productVariationRepository;

    @Autowired
    private ProductVariationMapper productVariationMapper;

    @Override
    public ProductVariationDTO createProductVariation(ProductVariationDTO productVariationDTO) {
        ProductVariation productVariation = productVariationMapper.toEntity(productVariationDTO);
        ProductVariation savedProductVariation = productVariationRepository.save(productVariation);
        return productVariationMapper.toDTO(savedProductVariation);
    }

    @Override
    public ProductVariationDTO getProductVariationById(int id) {
        ProductVariation productVariation = productVariationRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product Variation not found with ID: " + id));
        return productVariationMapper.toDTO(productVariation);
    }

    @Override
    public List<ProductVariationDTO> getAllProductVariations() {
        return productVariationRepository.findAll().stream()
                .map(productVariationMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ProductVariationDTO updateProductVariation(int id, ProductVariationDTO productVariationDTO) {
        ProductVariation existingProductVariation = productVariationRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product Variation not found with ID: " + id));
        productVariationMapper.map(productVariationDTO, existingProductVariation);
        ProductVariation updatedProductVariation = productVariationRepository.save(existingProductVariation);
        return productVariationMapper.toDTO(updatedProductVariation);
    }

    @Override
    public void deleteProductVariation(int id) {
        if (!productVariationRepository.existsById(id)) {
            throw new ResourceNotFoundException("Product Variation not found with ID: " + id);
        }
        productVariationRepository.deleteById(id);
    }
}