import axios from "axios";

const baseUrl = "http://localhost:8080/product/";

class ProductService {
  getAllProducts() {
    return axios.get(baseUrl + "products");
  }
}

export default new ProductService();
