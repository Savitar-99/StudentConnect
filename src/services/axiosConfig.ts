import axios from 'axios';

const axiosInstance = axios.create({
  baseURL: 'http://localhost:5000', // URL base de JSON Server
});

export default axiosInstance;
