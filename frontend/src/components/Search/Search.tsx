import React, { useState } from 'react'
import SearchSide from './SearchSide'
import SearchFiltersIcon from './SearchFiltersIcon'
import { ISearchData, ISearchInputs, IUseFilter, ISearchRadius } from './ISearch'
import useFilter from './useFilter'
import SearchMap from './SearchMap'

const Search = (props: ISearchData) => {

  const [isClicked, setIsClicked] = useState(false);
  const [radiusValue, setRadiusValue] = useState(0);

  const filterProps: IUseFilter = {
    isClicked: isClicked,
    setIsClicked: setIsClicked
  }

  const {
    openFilter,
    setOpenFilter,
    showMap
  } = useFilter({...filterProps});

  const radiusInput: ISearchRadius = {
    radiusValue: radiusValue,
    setRadiusValue: setRadiusValue
  }

  const searchInputs: ISearchInputs = {
    open: openFilter,
    setOpen: setOpenFilter,
    isClicked: isClicked,
    setIsClicked: setIsClicked,
    data: props,
    radius: radiusInput
  }

  return (
    <>
        <div className='relative h-[120vh] w-[100%] flex flex-row z-0 lg:h-[90vh]'>
            <SearchFiltersIcon {...searchInputs}/>
            <SearchSide {...searchInputs}/>
            { showMap && <SearchMap {...radiusInput}/> }
        </div>
    </>
    
  )
}

export default Search