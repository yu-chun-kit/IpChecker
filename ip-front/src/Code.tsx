import React, { useEffect } from "react";
// import {highlight, languages, highlightElement} from "prismjs";
import Prism from "prismjs";
import "prismjs/themes/prism-okaidia.css";

type Props = { code: string; language: string };

export default function Code({ code, language }: Props) {
  useEffect(() => {
    Prism.highlightAll();
  }, [code]);
  return (
    <div className="Code">
      {/* <h2> Code Syntax Block {language}</h2> */}
      <pre style={{padding: "20px"}}>
        <code className={`language-${language}`}>{code}</code>
      </pre>
    </div>
  );
}
