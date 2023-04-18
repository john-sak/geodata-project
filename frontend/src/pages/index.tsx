import { useEffect } from "react";
import { INavMenuProps } from "@/components/NavBar/Inav";
import Hero from "@/components/Hero/Hero";

export default function Home(props: INavMenuProps) {

  const { setNavbarProps } = props;

  useEffect(() => {
    setNavbarProps({
      menuColor: 'white'
    });
  },[])

  return (
    <>
      <Hero/>
    </>
  )
}
