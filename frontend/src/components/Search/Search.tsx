import React, { useState } from 'react'
import SearchSide from './SearchSide'
import SearchFiltersIcon from './SearchFiltersIcon'
import { ISearchData, ISearchInputs, IUseFilter, ISearchRadius, ISearchFreeTextInputProps} from './ISearch'
import useFilter from './useFilter'
import SearchMap from './SearchMap'
import SearchFreeText from './SearchFreeText'

const Search = (props: ISearchData) => {

  const { searchData } = props;
  const { freeText } = searchData;

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
    radius: radiusInput,
    showMap: showMap
  }

  const freeTextInput: ISearchFreeTextInputProps = {
    data: props,
    value: freeText,
    name: 'freeText',
    label: 'Ελεύθερη Αναζήτηση'
}
  // FreeText here and at SearchSide
  // Showing above 1024px and below only at the sidebar
  return (
    <>
        <div className='relative h-[120vh] w-[100%] flex flex-row z-0 lg:h-[90vh]'>
            <SearchFiltersIcon {...searchInputs}/>
            <SearchSide {...searchInputs}/>
            { showMap && <SearchMap {...radiusInput}/> }
            { showMap && <SearchFreeText {...freeTextInput}/> }
        </div>
    </>
    
  )
}

export default Search