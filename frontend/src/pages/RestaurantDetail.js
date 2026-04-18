import React, { useState, useEffect } from 'react';
import { useParams, useNavigate } from 'react-router-dom';
import axios from 'axios';
import './RestaurantDetail.css';

function RestaurantDetail() {
  const { restaurantId } = useParams();
  const navigate = useNavigate();
  const [restaurant, setRestaurant] = useState(null);
  const [foods, setFoods] = useState([]);
  const [cart, setCart] = useState([]);
  const [loading, setLoading] = useState(true);

  useEffect(() => {
    fetchRestaurantDetail();
    fetchFoods();
  }, [restaurantId]);

  const fetchRestaurantDetail = async () => {
    try {
      const response = await axios.get(
        `http://localhost:8080/api/restaurants/${restaurantId}`
      );
      setRestaurant(response.data);
    } catch (err) {
      console.error('Failed to fetch restaurant:', err);
    }
  };

  const fetchFoods = async () => {
    try {
      const response = await axios.get(
        `http://localhost:8080/api/foods/restaurant/${restaurantId}`
      );
      setFoods(response.data);
      setLoading(false);
    } catch (err) {
      console.error('Failed to fetch foods:', err);
      setLoading(false);
    }
  };

  const addToCart = (food) => {
    const existingItem = cart.find((item) => item.id === food.id);
    if (existingItem) {
      existingItem.quantity += 1;
      setCart([...cart]);
    } else {
      setCart([...cart, { ...food, quantity: 1 }]);
    }
  };

  const removeFromCart = (foodId) => {
    setCart(cart.filter((item) => item.id !== foodId));
  };

  const updateQuantity = (foodId, quantity) => {
    if (quantity === 0) {
      removeFromCart(foodId);
    } else {
      const item = cart.find((item) => item.id === foodId);
      if (item) {
        item.quantity = quantity;
        setCart([...cart]);
      }
    }
  };

  const handleCheckout = async () => {
    if (cart.length === 0) {
      alert('Cart is empty!');
      return;
    }

    try {
      const orderData = {
        restaurantId: restaurantId,
        items: cart,
        totalAmount: calculateTotal(),
      };

      await axios.post('http://localhost:8080/api/orders', orderData);
      alert('Order placed successfully!');
      setCart([]);
      navigate('/order');
    } catch (err) {
      console.error('Failed to place order:', err);
      alert('Failed to place order');
    }
  };

  const calculateTotal = () => {
    return cart.reduce((total, item) => total + item.price * item.quantity, 0);
  };

  if (loading) {
    return <div className="loading">Loading...</div>;
  }

  if (!restaurant) {
    return <div className="error">Restaurant not found</div>;
  }

  return (
    <div className="restaurant-detail">
      <div className="restaurant-header">
        <h1>{restaurant.name}</h1>
        <p>{restaurant.cuisine} • {restaurant.address}</p>
        <p>⭐ {restaurant.rating} • 🚗 {restaurant.deliveryTime} mins</p>
      </div>

      <div className="detail-container">
        <div className="foods-section">
          <h2>Menu</h2>
          <div className="foods-list">
            {foods.map((food) => (
              <div key={food.id} className="food-item">
                <div className="food-info">
                  <h3>{food.name}</h3>
                  <p>{food.description}</p>
                  <p className="price">₹{food.price}</p>
                </div>
                <button 
                  className="add-btn"
                  onClick={() => addToCart(food)}
                >
                  Add
                </button>
              </div>
            ))}
          </div>
        </div>

        <div className="cart-section">
          <h2>Your Cart</h2>
          {cart.length === 0 ? (
            <p className="empty-cart">Your cart is empty</p>
          ) : (
            <>
              <div className="cart-items">
                {cart.map((item) => (
                  <div key={item.id} className="cart-item">
                    <div className="item-details">
                      <p>{item.name}</p>
                      <p>₹{item.price}</p>
                    </div>
                    <div className="quantity-controls">
                      <button onClick={() => updateQuantity(item.id, item.quantity - 1)}>
                        −
                      </button>
                      <span>{item.quantity}</span>
                      <button onClick={() => updateQuantity(item.id, item.quantity + 1)}>
                        +
                      </button>
                    </div>
                    <p className="item-total">₹{item.price * item.quantity}</p>
                  </div>
                ))}
              </div>
              <div className="cart-total">
                <strong>Total: ₹{calculateTotal()}</strong>
              </div>
              <button 
                className="checkout-btn"
                onClick={handleCheckout}
              >
                Checkout
              </button>
            </>
          )}
        </div>
      </div>
    </div>
  );
}

export default RestaurantDetail;
