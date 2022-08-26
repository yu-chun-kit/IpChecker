import axios from "axios";

export default axios.create({
  baseURL: "http://localhost:2019",
  headers: { "Content-Type": "application/json" },
});
