import React, { useState, useEffect } from 'react';
import axios from 'axios';
import './Order.css';

function Order() {
  const [orders, setOrders] = useState([]);
  const [loading, setLoading] = useState(true);

  useEffect(() => {
    fetchOrders();
  }, []);

  const fetchOrders = async () => {
    try {
      const response = await axios.get('http://localhost:8080/api/orders');
      setOrders(response.data);
      setLoading(false);
    } catch (err) {
      console.error('Failed to fetch orders:', err);
      setLoading(false);
    }
  };

  if (loading) {
    return <div className="loading">Loading orders...</div>;
  }

  return (
    <div className="orders-page">
      <div className="container">
        <h1>Your Orders</h1>
        
        {orders.length === 0 ? (
          <div className="no-orders">
            <p>No orders placed yet!</p>
          </div>
        ) : (
          <div className="orders-list">
            {orders.map((order) => (
              <div key={order.id} className="order-card">
                <div className="order-header">
                  <h3>Order #{order.id}</h3>
                  <span className={`status ${order.status.toLowerCase()}`}>
                    {order.status}
                  </span>
                </div>
                <div className="order-details">
                  <p><strong>Restaurant ID:</strong> {order.restaurantId}</p>
                  <p><strong>Total Amount:</strong> ₹{order.totalAmount}</p>
                  <p><strong>Order Date:</strong> {new Date(order.orderDate).toLocaleString()}</p>
                </div>
                <div className="order-items">
                  <h4>Items:</h4>
                  {order.items && order.items.length > 0 ? (
                    <ul>
                      {order.items.map((item, index) => (
                        <li key={index}>
                          {item.name} x {item.quantity} - ₹{item.price * item.quantity}
                        </li>
                      ))}
                    </ul>
                  ) : (
                    <p>No items in order</p>
                  )}
                </div>
              </div>
            ))}
          </div>
        )}
      </div>
    </div>
  );
}

export default Order;
