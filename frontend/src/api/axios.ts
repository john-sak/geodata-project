import axios,{ AxiosInstance } from "axios";

const BASE_URL = 'http://localhost:8080';

export default axios.create({
    baseURL: BASE_URL,
    headers:{
        "Content-Type": "application/json",
    }
});

export const axiosPrivate: AxiosInstance = axios.create({
    baseURL: BASE_URL,
    headers: {
      "Content-Type": "application/json"
    }
  });