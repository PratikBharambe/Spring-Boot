import React, { useState, useEffect } from "react";
import ProductService from "../service/ProductService";

function DisplayProducts() {
  const [prodarr, setProdArr] = useState([]);

  useEffect(() => {
    fetchData();
  }, []);

  const fetchData = () => {
    ProductService.getAllProducts()
      .then((result) => {
        setProdArr([...result.data]);
      })
      .catch((err) => {
        console.log(err);
      });
  };

  return (
    <div className="flex justify-center m-1 p-2 text-xl">
      <table className="table-auto border-separate border border-slate-500 " border="2">
        <thead>
          <tr>
            <th className="p-2">Product Id</th>
            <th className="p-2">Name</th>
            <th className="p-2">Quantity</th>
            <th className="p-2">Price</th>
            <th className="p-2">Exp Date</th>
            <th className="p-2">Category Id</th>
            <th className="p-2">Action</th>
          </tr>
        </thead>
        <tbody>
          {prodarr.map((prod) => (
            <tr key={prod.id}>
              <td className="p-2">{prod.id}</td>
              <td className="p-2">{prod.name}</td>
              <td className="p-2">{prod.qty}</td>
              <td className="p-2">{prod.price}</td>
              <td className="p-2">{prod.expdate}</td>
              <td className="p-2">{prod.cid}</td>
              <td className="p-2">
                <button
                  type="button"
                  name="delete"
                  id="delete"
                  value="delete"
                  className="text-white bg-red-700 hover:bg-red-800 focus:outline-none focus:ring-4 focus:ring-red-300 font-medium rounded-full text-sm px-5 py-2.5 text-center me-2 mb-2 dark:bg-red-600 dark:hover:bg-red-700 dark:focus:ring-red-900"
                >
                  Delete
                </button>
                &nbsp;&nbsp;&nbsp;
                <button
                  type="button"
                  name="edit"
                  id="edit"
                  value="edit"
                  className="text-white bg-blue-700 hover:bg-blue-800 focus:outline-none focus:ring-4 focus:ring-blue-300 font-medium rounded-full text-sm px-5 py-2.5 text-center me-2 mb-2 dark:bg-blue-600 dark:hover:bg-blue-700 dark:focus:ring-blue-800"
                >
                  Edit
                </button>
                &nbsp;&nbsp;&nbsp;
                <button
                  type="button"
                  name="view"
                  id="view"
                  value="view"
                  className="text-white bg-green-700 hover:bg-green-800 focus:outline-none focus:ring-4 focus:ring-green-300 font-medium rounded-full text-sm px-5 py-2.5 text-center me-2 mb-2 dark:bg-green-600 dark:hover:bg-green-700 dark:focus:ring-green-800"
                >
                  View
                </button>
              </td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
}

export default DisplayProducts;
