package com.example.promoanalysis.projection;

import java.util.List;

public class DailySalesRequest {
    private List<String> chains;
    private List<String> products;

    public DailySalesRequest() {}

    public List<String> getChains() {
        return chains;
    }

    public void setChains(List<String> chains) {
        this.chains = chains;
    }

    public List<String> getProducts() {
        return products;
    }

    public void setProducts(List<String> products) {
        this.products = products;
    }
}
