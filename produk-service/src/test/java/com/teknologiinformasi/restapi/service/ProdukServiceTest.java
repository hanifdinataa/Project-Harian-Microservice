package com.teknologiinformasi.restapi.service;

import com.teknologiinformasi.restapi.service.ProdukService;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;


import java.util.Arrays;
import java.util.List;
import java.util.Optional;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;


import com.teknologiinformasi.restapi.model.Produk;
import com.teknologiinformasi.restapi.repository.ProdukRepository;


public class ProdukServiceTest {
  
   @Mock
   private ProdukRepository produkRepository;


   @InjectMocks
   private ProdukService produkService;


   @BeforeEach
   public void setUp(){
       MockitoAnnotations.openMocks(this);
   }


   @Test
   public void testCreateProduk(){
       //inisialisasi object produk
       Produk produk = new Produk();
       produk.setNama("iphone 16");
       produk.setDeskripsi("iphone 16 256gb edition");
       //proses simpan data produk
       when(produkRepository.save(produk)).thenReturn(produk);
       //test hasil setelah data produk disimpan
       Produk result = produkService.createProduk(produk);
       assertNotNull(result);
       assertEquals("iphone 16", result.getNama());
       verify(produkRepository,times(1)).save(produk);


   }


   @Test
   public void getAllProduk(){
       Produk p1 = new Produk();
       p1.setNama("Laptop");
       Produk p2 = new Produk();
       p2.setNama("PC");


       when(produkRepository.findAll()).thenReturn(Arrays.asList(p1,p2));
       List<Produk> result = produkService.getAllProduk();
       assertEquals(2, result.size());
       verify(produkRepository,times(1)).findAll();
      
   }

   @Test
   public void testGetProdukById_found() {
       Produk produk = new Produk();
       produk.setId(1L);
       produk.setNama("Mouse");


       when(produkRepository.findById(1L)).thenReturn(Optional.of(produk));


       Optional<Produk> result = produkService.getProdukById(1L);
       assertTrue(result.isPresent());
       assertEquals("Mouse", result.get().getNama());
       verify(produkRepository, times(1)).findById(1L);
   }

   @Test
   public void testUpdateProduk_success() {
       Produk existing = new Produk();
       existing.setId(1L);
       existing.setNama("Old Name");
       existing.setDeskripsi("Old Desc");


       Produk update = new Produk();
       update.setNama("New Name");
       update.setDeskripsi("New Desc");


       when(produkRepository.findById(1L)).thenReturn(Optional.of(existing));
       when(produkRepository.save(any(Produk.class))).thenAnswer(i -> i.getArgument(0));


       Produk result = produkService.updateProduk(1L, update);
       assertEquals("New Name", result.getNama());
       assertEquals("New Desc", result.getDeskripsi());
   }

   @Test
   public void testUpdateProduk_notFound() {
       Produk update = new Produk();
       update.setNama("Should Fail");


       when(produkRepository.findById(999L)).thenReturn(Optional.empty());


       RuntimeException thrown = assertThrows(RuntimeException.class, () -> {
           produkService.updateProduk(999L, update);
       });


       assertTrue(thrown.getMessage().contains("Produk tidak ditemukan"));
   }

   @Test
   public void testDeleteProduk_success() {
       Produk produk = new Produk();
       produk.setId(1L);


       when(produkRepository.findById(1L)).thenReturn(Optional.of(produk));
       doNothing().when(produkRepository).delete(produk);


       produkService.deleteProduk(1L);
       verify(produkRepository, times(1)).delete(produk);
   }

   @Test
   public void testDeleteProduk_notFound() {
       when(produkRepository.findById(999L)).thenReturn(Optional.empty());


       RuntimeException thrown = assertThrows(RuntimeException.class, () -> {
           produkService.deleteProduk(999L);
       });


       assertTrue(thrown.getMessage().contains("Produk tidak ditemukan"));
   }

}