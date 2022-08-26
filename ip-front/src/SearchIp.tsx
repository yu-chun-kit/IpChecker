import React, { useState } from "react";
import { TextField, FormControl, Typography } from "@mui/material";

type Props = {
  setIpDetail: (ip: string) => void;
};

export default function SearchIp({ setIpDetail }: Props) {
  const [ipAddress, setIpAddress] = useState<string>("");
  const [valid, setValid] = useState<boolean>(false);

  const checkInvalidIp = (link: string) => {
    let re = /\b(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?(\.|$)){4}\b/;
    let validLink = re.test(link);
    // valid and current invalid
    if (valid === !validLink) {
      setValid(validLink);
    }

    return !validLink;
  };

  const handleSubmit = (event: React.SyntheticEvent<HTMLFormElement>) => {
    event.preventDefault();
    // You should see email and password in console.
    // ..code to submit form to backend here...
    if (valid) {
      // getIpAddress();
      setIpDetail(ipAddress);
    } else {
      console.log(`Invalid ip address ${ipAddress}!!!`);
    }
  };

  return (
    <form onSubmit={handleSubmit}>
      <FormControl error variant="standard">
        <Typography variant="h5" component="h2" gutterBottom>
          Please Search for IP
        </Typography>
        <TextField
          id="outlined-basic"
          label="IP search"
          variant="outlined"
          value={ipAddress}
          onChange={(e) => setIpAddress(e.target.value)}
          error={checkInvalidIp(ipAddress)}
          // helperText={checkError(ipAddress) ? `Invalid ip address ${ipAddress}` : ""}
        />
        {/* <Button variant="contained">Send</Button> */}
      </FormControl>
    </form>
  );
}
