import { useState, useEffect } from 'react'
import { IUseFilter } from './ISearch';

const useFilter = (props: IUseFilter) => {

    const { isClicked, setIsClicked } = props;
    
    const [openFilter, setOpenFilter] = useState(false);
    const [screenWidth, setScreenWidth] = useState(window.innerWidth);
    const [prevScreenWidth, setPrevScreenWidth] = useState(window.innerWidth);
    const [showMap, setShowMap] = useState(true);

    useEffect(() => {
        const handleResize = () => {
            setScreenWidth(window.innerWidth);
        }
        window.addEventListener("resize", handleResize);
        return () => {
            window.removeEventListener("resize", handleResize);
        }
    })

    // Closed by default on mobile, open on desktop
    // Closing when resizing below 1024px from beyond
    // Keeping its state when resizing below 1024px
    // Map open below and above 1024, closed below 1024 when clicked
    useEffect(() => {
        if(screenWidth <= 1024 && prevScreenWidth > 1024) {
          setOpenFilter(false);
          setShowMap(true);
          setIsClicked(false);
        } 
        else if(screenWidth > 1024 && prevScreenWidth <= 1024) {
          setOpenFilter(true);
          setShowMap(true);
          setIsClicked(false);
        } 
        else if(screenWidth > 1024) {
          setOpenFilter(true);
          setShowMap(true);
          setIsClicked(false);
        } 
        else if(screenWidth <= 1024) {
            if(isClicked) {
                setShowMap(false);
            }
            else {
                setShowMap(true);
            }
        }
    
        setPrevScreenWidth(screenWidth);
      }, [screenWidth, prevScreenWidth, isClicked])


    return { openFilter, setOpenFilter, showMap }
}

export default useFilter