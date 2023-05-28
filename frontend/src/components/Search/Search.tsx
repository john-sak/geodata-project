import React, { useState } from 'react'
import SearchSide from './SearchSide'
import SearchFiltersIcon from './SearchFiltersIcon'
import { ISearchData, ISearchInputs, IUseFilter } from './ISearch'
import useFilter from './useFilter'
import SearchMap from './SearchMap'

const Search = (props: ISearchData) => {

  const [isClicked, setIsClicked] = useState(false);

  const filterProps: IUseFilter = {
    isClicked: isClicked,
    setIsClicked: setIsClicked
  }

  const {
    openFilter,
    setOpenFilter,
    showMap
  } = useFilter({...filterProps});

  const searchInputs: ISearchInputs = {
    open: openFilter,
    setOpen: setOpenFilter,
    isClicked: isClicked,
    setIsClicked: setIsClicked,
    data: props
  }

  return (
    <>
        <div className='relative h-[800px] w-[100%] bg-sky-400 flex flex-row z-0'>
            <SearchFiltersIcon {...searchInputs}/>
            <SearchSide {...searchInputs}/>
            { showMap && <SearchMap/> }
        </div>
        {
          openFilter && 
            <div className='h-[300px] w-[100%] bg-red-900'>

            </div>
        }
        
    </>
    
  )
}

export default Search