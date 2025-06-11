<?php
namespace App\Http\Controllers;


use Illuminate\Http\Request;
use App\Services\CustomerService;


class CustomerController extends Controller
{
   protected $CustomerService;


   public function __construct(CustomerService $CustomerService)
   {
       $this->CustomerService = $CustomerService;
   }


   public function index()
   {
       $Customers = $this->CustomerService->getAll();
       return view('Customer.index', compact('Customers'));
   }


   public function create()
   {
       return view('Customer.create');
   }


   public function store(Request $request)
   {
       $this->CustomerService->create($request->only('nama', 'email', 'address'));
       return redirect('/Customer')->with('success', 'Customer berhasil ditambahkan');
   }


   public function edit($id)
   {
       $Customer = $this->CustomerService->find($id);
       return view('Customer.edit', compact('Customer'));
   }


   public function update(Request $request, $id)
   {
       $this->CustomerService->update($id, $request->only('nama', 'deskripsi', 'harga'));
       return redirect('/Customer')->with('success', 'Customer berhasil diupdate');
   }


   public function destroy($id)
   {
       $this->CustomerService->delete($id);
       return redirect('/Customer')->with('success', 'Customer berhasil dihapus');
   }
}




