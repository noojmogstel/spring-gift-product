package gift.controller;


import gift.domain.Product;
import gift.domain.Products;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class ProductController {

    Products products = new Products();

    //전체 product 목록 조회
    @GetMapping
    public Products getProduct(){
        return products;
    }

    //product 추가
    @PostMapping
    public ResponseEntity<String> addProduct(@RequestBody Product product){
        if(products.add(product)){
            return new ResponseEntity<>("OK", HttpStatus.CREATED);
        }
        return new ResponseEntity<>("올바르지 않은 요청",HttpStatus.BAD_REQUEST);
    }

    //product 수정
    @PatchMapping("/edit/{id}")
    public String editProduct(@PathVariable("id") Long id, @RequestBody Product product){
        if(products.edit(id,product)){
            return "product edit success";
        }
        return "올바르지 않은 요청";
    }

    //product 삭제
    @DeleteMapping("/delete/{id}")
    public String deleteProduct(@PathVariable("id") Long id){
        if(products.delete(id)){
            return "product delete success";
        }
        return "올바르지 않은 요청";
    }
}
