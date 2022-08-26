import { useEffect, useState } from "react";
import ip_api from "../apis/ip_api";
import axios from "axios";

export default (defaultIp: string): [object, (ip: string) => void] => {
  const [ipAddress, setIpAddress] = useState<object>({});
  useEffect(() => {
    setIp(defaultIp);
  }, []);
  const setIp = async (ip: string) => {
    const { data } = await ip_api.get(`/ipaddress/${ip}`);
    // .catch((err) => {
    //   return { data: err };
    // });
    console.log(data);
    if (!data.status) {
      setIpAddress(Object.assign({}, data, { status: "success" }));
      return;
    }
    const { data: data2 } = await axios.get(
      `http://demo.ip-api.com/json/${ip}`
    );
    setIpAddress(data2);
    if (data2.status === "success") {
      const ipAddress = Object.assign({}, data2, { ipAddress: data2.query });
      console.log(ipAddress);
      await ip_api.post("/ipaddresses", ipAddress);
    }
  };
  return [ipAddress, setIp];
};
