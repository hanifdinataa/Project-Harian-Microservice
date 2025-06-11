<?php

use Illuminate\Support\Facades\Route;
// use Illuminate\Support\Facades\Route;
use App\Http\Controllers\ProdukController;
use App\Services\ProdukService;

Route::get('produk/create',[ProdukService::class,'create'])
->name('produks.create');
Route::post('produk',[ProdukService::class,'store'])
->name('produks.store');
Route::get('produk',[ProdukService::class,'index'])
->name('produks.index');
Route::get('produk/{id}/edit',[ProdukService::class,'edit'])
->name('produks.edit');
Route::put('produk/{id}',[ProdukService::class,'update'])
->name('produks.update');
Route::delete('produk/{id}',[ProdukService::class,'destroy'])
->name('produks.destroy');
