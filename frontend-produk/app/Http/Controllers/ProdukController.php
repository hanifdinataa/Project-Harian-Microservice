<?php
namespace App\Http\Controllers;


use Illuminate\Http\Request;
use App\Services\ProdukService;


class ProdukController extends Controller
{
   protected $produkService;


   public function __construct(ProdukService $produkService)
   {
       $this->produkService = $produkService;
   }


   public function index()
   {
       $produks = $this->produkService->getAll();
       return view('produk.index', compact('produks'));
   }


   public function create()
   {
       return view('produk.create');
   }


   public function store(Request $request)
   {
       $this->produkService->create($request->only('nama', 'deskripsi', 'harga'));
       return redirect('/produk')->with('success', 'Produk berhasil ditambahkan');
   }


   public function edit($id)
   {
       $produk = $this->produkService->find($id);
       return view('produk.edit', compact('produk'));
   }


   public function update(Request $request, $id)
   {
       $this->produkService->update($id, $request->only('nama', 'deskripsi', 'harga'));
       return redirect('/produk')->with('success', 'Produk berhasil diupdate');
   }


   public function destroy($id)
   {
       $this->produkService->delete($id);
       return redirect('/produk')->with('success', 'Produk berhasil dihapus');
   }
}




