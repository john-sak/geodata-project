import { useState, useEffect } from 'react'

const useFilter = () => {
    
    const [openFilter, setOpenFilter] = useState(false);
    const [screenWidth, setScreenWidth] = useState(window.innerWidth);
    const [prevScreenWidth, setPrevScreenWidth] = useState(window.innerWidth);

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
    useEffect(() => {
        if(screenWidth <= 1024 && prevScreenWidth > 1024 && openFilter) {
          setOpenFilter(false);
        } 
        else if(screenWidth > 1024 && prevScreenWidth <= 1024) {
          setOpenFilter(true);
        }
        else if(screenWidth > 1024) {
            setOpenFilter(true);
        }
    
        setPrevScreenWidth(screenWidth);
    }, [screenWidth, prevScreenWidth, openFilter])


    return { openFilter, setOpenFilter }
}

export default useFilter