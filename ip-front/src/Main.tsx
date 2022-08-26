import React from "react";
import { Grid, Box, Paper } from "@mui/material";
import SearchIp from "./SearchIp";
import { styled } from "@mui/material/styles";
import Code from "./Code";
import useIp from "./hooks/useIp";

type Props = {};
const Item = styled(Paper)(({ theme }) => ({
  ...theme.typography.body2,
  // textAlign: "center",
  color: theme.palette.text.secondary,
  height: "auto",
  width: "auto",
  // lineHeight: "60px",
}));

type IpDetailProps = {
  status: string;
  country?: string;
  countryCode?: string;
  region?: string;
  regionName: string;
  city: string;
  zip: string;
  lat: number;
  lon: number;
  timezone: string;
  isp: string;
  org: string;
  as: string;
  query: string;
};

function Main(props: Props) {
  const [ipDetail, setIpDetail] = useIp("1.1.1.1");

  return (
    <Grid
      container
      spacing={0}
      direction="column"
      alignItems="center"
      justifyContent="center"
      style={{ minHeight: "100vh" }}
    >
      <SearchIp setIpDetail={setIpDetail} />
      {Object.keys(ipDetail).length === 0 ? null : (
        <Box
          sx={{
            display: "flex",
            "& > :not(style)": {
              m: 3,
              width: "auto",
              height: "auto",
              padding: 2,
            },
          }}
        >
          <Item key={0} elevation={12}>
            <Code
              language="javascript"
              code={JSON.stringify(ipDetail, null, 4)}
            />
          </Item>
        </Box>
      )}
    </Grid>
  );
}

export default Main;
