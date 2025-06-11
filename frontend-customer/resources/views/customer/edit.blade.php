@extends('layouts.main')


@section('content')
   <h2>Edit Customer</h2>


   @if ($errors->any())
       <div style="color:red;">
           <ul>
               @foreach ($errors->all() as $error)
                   <li>{{ $error }}</li>
               @endforeach
           </ul>
       </div>
   @endif


   <form action="{{ route('Customers.update', $Customer['id']) }}" method="POST">
       @csrf
       @method('PUT')


       <label>Nama:</label>
       <input type="text" name="nama" value="{{ old('nama', $Customer['nama']) }}"><br>


       <label>email:</label>
       <input type="text" name="email" value="{{ old('email', $Customer['email']) }}"><br>


       <label>address:</label>
       <input type="address" name="address" value="{{ old('address', $Customer['address']) }}"><br>
<p></p>
       <button type="submit">Update</button>
   </form>
@endsection


