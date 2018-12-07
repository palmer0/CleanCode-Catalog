package es.ulpgc.eite.cleancode.catalog.product;

import android.arch.lifecycle.ViewModel;

import es.ulpgc.eite.cleancode.catalog.data.CatalogItem;

// include this library dependency in build.gradle file
// implementation 'android.arch.lifecycle:extensions:1.1.1'
public class ProductDetailViewModel extends ViewModel {

  public CatalogItem product;
}

