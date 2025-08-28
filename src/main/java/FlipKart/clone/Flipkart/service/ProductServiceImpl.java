package FlipKart.clone.Flipkart.service;

import FlipKart.clone.Flipkart.entity.Product;
import FlipKart.clone.Flipkart.enums.MainCategory;
import FlipKart.clone.Flipkart.enums.SubCategory;
import FlipKart.clone.Flipkart.repository.ProductRepository;
import FlipKart.clone.Flipkart.uniqueIdGenerator.SKUGenerator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product saveProduct(Product product) {
        log.info("product is being saved in DB service class: product {}", product);

        SubCategory subCategory =  product.getSubCategoryType();
        MainCategory mainCategory = subCategory.getParentCategory();
        product.setMainCatagoryType(mainCategory);
        log.info("setting main catagory for the subCategory {}", product.getSubCategoryType());

        log.info("generating unique SKU for the product {} ", product.getName());
        product.setSKU(SKUGenerator.generateUniqueSKUId());

        Product saveProduct = productRepository.save(product);
        log.info("product is successfully save in DB: {} ", saveProduct);

        return saveProduct;

    }
}
