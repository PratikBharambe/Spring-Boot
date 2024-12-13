import React from "react";
import { NavLink } from "react-router-dom";

function Navbar() {
  const navbarData = [
    { title: "Home", link: "/home" },
    { title: "Product", link: "/products" },
    { title: "Catagory", link: "/catagories" },
    { title: "Product Form", link: "/productform" },
    { title: "About US", link: "/aboutus" }
  ];

  return (
      <nav className="flex items-center m-auto pt-5 justify-between p-4 h-16">
        <div className="flex items-center gap-6 text-[1.5rem]">
          <div className="flex items-center p-2 justify-center">
            {
                navbarData.map((item) => (
                    <div className="font-semibold font-sans">
                        <a href={item.link} className="flex items-center justify-center p-2 hover:text-[#303dfb]">
                            <NavLink className="p-1" to={item.link}>{item.title}</NavLink>
                        </a>
                    </div>
                ))
            }
          </div>
        </div>
      </nav>
  );
}

export default Navbar;