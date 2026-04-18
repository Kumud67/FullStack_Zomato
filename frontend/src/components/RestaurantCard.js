import React from 'react';
import { Link } from 'react-router-dom';
import './RestaurantCard.css';

function RestaurantCard({ restaurant }) {
  return (
    <Link to={`/restaurant/${restaurant.id}`} className="restaurant-card">
      <div className="restaurant-image">
        <span className="rating">⭐ {restaurant.rating}</span>
      </div>
      <div className="restaurant-info">
        <h3>{restaurant.name}</h3>
        <p className="cuisine">{restaurant.cuisine}</p>
        <p className="address">{restaurant.address}</p>
        <p className="delivery">🚗 {restaurant.deliveryTime} mins | ₹{restaurant.deliveryCharge}</p>
      </div>
    </Link>
  );
}

export default RestaurantCard;
