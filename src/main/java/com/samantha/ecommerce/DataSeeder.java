package com.samantha.ecommerce;

import com.samantha.ecommerce.model.Category;
import com.samantha.ecommerce.model.Product;
import com.samantha.ecommerce.repository.CategoryRepository;
import com.samantha.ecommerce.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

@Component
public class DataSeeder implements CommandLineRunner {

    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;

    public DataSeeder(CategoryRepository categoryRepository, ProductRepository productRepository) {
        this.categoryRepository = categoryRepository;
        this.productRepository = productRepository;
    }

    @Override
    public void run(String... args) {
        if (categoryRepository.count() > 0) return;

        Category women     = saveCategory("Women");
        Category men       = saveCategory("Men");
        Category accessories = saveCategory("Accessories");
        Category footwear  = saveCategory("Footwear");
        Category home      = saveCategory("Home");
        Category beauty    = saveCategory("Beauty");

        // Women
        saveProduct("Floral Wrap Dress",          "A breezy floral-print wrap dress with a tie waist",         "49.99",  120, women);
        saveProduct("High-Waist Skinny Jeans",    "Stretch denim with a flattering high-rise silhouette",      "59.99",  200, women);
        saveProduct("Lace Trim Blouse",           "Lightweight blouse with delicate lace detailing at the hem","35.00",  150, women);
        saveProduct("Oversized Blazer",           "Relaxed-fit blazer in a classic neutral tone",              "89.99",   80, women);
        saveProduct("Ribbed Knit Sweater",        "Cozy fitted sweater in a fine rib knit",                   "45.00",  100, women);
        saveProduct("Pleated Midi Skirt",         "Elegant flowing midi skirt with knife pleats",              "42.00",   90, women);
        saveProduct("Satin Slip Dress",           "Minimalist satin slip dress, perfect for layering",         "65.00",   70, women);
        saveProduct("Cropped Denim Jacket",       "Classic cropped denim jacket with a vintage wash",          "75.00",   60, women);

        // Men
        saveProduct("Classic Fit Oxford Shirt",  "Crisp cotton Oxford shirt with button-down collar",         "45.00",  150, men);
        saveProduct("Slim Fit Chinos",            "Versatile chinos in a modern slim cut",                     "55.00",  120, men);
        saveProduct("Merino Wool Crew Sweater",   "Soft merino wool sweater for everyday wear",               "79.99",   80, men);
        saveProduct("Relaxed Fit Hoodie",         "Brushed fleece hoodie with a kangaroo pocket",              "59.99",  200, men);
        saveProduct("Linen Shorts",               "Breathable linen shorts ideal for warm weather",            "35.00",  100, men);
        saveProduct("Tailored Suit Jacket",       "Single-breasted jacket with a modern slim lapel",          "199.99",   40, men);
        saveProduct("Graphic Tee",                "100% cotton tee with an oversized vintage graphic print",  "25.00",  300, men);
        saveProduct("Cargo Trousers",             "Relaxed cargo trousers with multiple utility pockets",      "65.00",   90, men);

        // Accessories
        saveProduct("Leather Tote Bag",           "Structured genuine leather tote with interior pockets",    "89.99",   60, accessories);
        saveProduct("Silk Scarf",                 "Hand-rolled 100% silk scarf with a printed pattern",       "45.00",  100, accessories);
        saveProduct("Aviator Sunglasses",         "Classic metal-frame aviators with UV400 lenses",           "35.00",  150, accessories);
        saveProduct("Canvas Backpack",            "Durable canvas backpack with laptop sleeve",               "55.00",   80, accessories);
        saveProduct("Beaded Bracelet Set",        "Set of 5 stackable beaded bracelets in mixed tones",       "18.00",  200, accessories);
        saveProduct("Wool Knit Beanie",           "Chunky-knit beanie in a soft merino blend",                "22.00",  180, accessories);
        saveProduct("Leather Belt",               "Full-grain leather belt with a polished silver buckle",    "29.99",  120, accessories);
        saveProduct("Crossbody Mini Bag",         "Compact crossbody bag with an adjustable strap",           "49.99",   70, accessories);

        // Footwear
        saveProduct("White Leather Sneakers",     "Clean minimal leather sneakers with a cushioned sole",     "85.00",  100, footwear);
        saveProduct("Block Heel Mules",           "Open-toe mules with a comfortable block heel",             "65.00",   70, footwear);
        saveProduct("Chelsea Boots",              "Pull-on Chelsea boots in smooth suede",                   "110.00",   60, footwear);
        saveProduct("Strappy Sandals",            "Barely-there strappy sandals with a slim heel",            "55.00",   80, footwear);
        saveProduct("Running Trainers",           "Lightweight trainers with responsive cushioning",          "95.00",  120, footwear);
        saveProduct("Loafers",                    "Slip-on penny loafers in polished leather",                "79.99",   90, footwear);
        saveProduct("Ankle Boots",                "Pointed-toe ankle boots with a stacked heel",              "99.99",   75, footwear);
        saveProduct("Platform Sandals",           "Chunky platform sandals with an adjustable buckle strap",  "72.00",   65, footwear);

        // Home
        saveProduct("Scented Soy Candle",         "Hand-poured soy candle with a 50-hour burn time",          "24.99",  200, home);
        saveProduct("Linen Throw Blanket",        "Stonewashed linen throw in a relaxed natural weave",       "49.99",   80, home);
        saveProduct("Ceramic Mug Set",            "Set of 4 hand-glazed ceramic mugs, 350ml each",            "32.00",  150, home);
        saveProduct("Marble Serving Board",       "Solid marble board with brass handles for entertaining",   "55.00",   60, home);
        saveProduct("Woven Storage Basket",       "Handwoven seagrass basket with a removable lining",        "38.00",   90, home);
        saveProduct("Bamboo Desk Organizer",      "Modular bamboo organizer with 5 compartments",             "29.99",  100, home);
        saveProduct("Decorative Throw Pillow",    "Textured velvet cushion cover with a hidden zip",          "35.00",  120, home);
        saveProduct("Glass Terrarium",            "Geometric glass terrarium for succulents and air plants",  "42.00",   70, home);

        // Beauty
        saveProduct("Vitamin C Serum",            "Brightening 15% vitamin C serum with hyaluronic acid",    "39.99",  150, beauty);
        saveProduct("Hydrating Face Mask",        "Overnight gel mask with aloe vera and ceramides",          "18.00",  200, beauty);
        saveProduct("Rose Water Toner",           "Balancing rose water toner for all skin types",            "22.00",  180, beauty);
        saveProduct("SPF 50 Sunscreen",           "Lightweight daily sunscreen with a matte finish",          "29.99",  250, beauty);
        saveProduct("Matte Lip Color Set",        "Set of 6 long-wear matte liquid lipsticks",                "34.00",  120, beauty);
        saveProduct("Volumizing Mascara",         "Buildable formula for lifted, voluminous lashes",          "19.99",  200, beauty);
        saveProduct("Nourishing Hair Oil",        "Lightweight argan oil blend for shine and frizz control",  "28.00",  100, beauty);
        saveProduct("Natural Exfoliating Scrub",  "Gentle walnut shell scrub with shea butter and vitamin E", "24.99",  130, beauty);

        System.out.println("✅ Seeded 6 categories and 48 products!");
    }

    private Category saveCategory(String name) {
        Category c = new Category();
        c.setName(name);
        return categoryRepository.save(c);
    }

    private void saveProduct(String name, String description, String price, int stock, Category category) {
        Product p = new Product();
        p.setName(name);
        p.setDescription(description);
        p.setPrice(new BigDecimal(price));
        p.setStock(stock);
        p.setCategory(category);
        productRepository.save(p);
    }
}
