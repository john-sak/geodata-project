import React, { useState } from 'react'
import SearchSide from './SearchSide'
import SearchFiltersIcon from './SearchFiltersIcon'
import { ISearchData, ISearchInputs, IUseFilter, ISearchFreeTextInputProps, ISearchMap} from './ISearch'
import useFilter from './useFilter'
import SearchMap from './SearchMap'
import SearchFreeText from './SearchFreeText'
import useFindResults from './useFindResults'

const Search = (props: ISearchData) => {

  const { searchData, location } = props;
  const { freeText } = searchData;

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
    data: props,
    location: location,
    showMap: showMap
  }

  const freeTextInput: ISearchFreeTextInputProps = {
    data: props,
    value: freeText,
    name: 'freeText',
    label: 'Ελεύθερη Αναζήτηση'
  }

  const { results } = useFindResults({...props});
  console.log('results', results);

  const mapData: ISearchMap = {
    search: location,
    results: results
  }

  // FreeText here and at SearchSide
  // Showing above 1024px and below only at the sidebar
  return (
    <>
        <div className='relative h-[120vh] w-[100%] flex flex-row z-0 lg:h-[90vh]'>
            <SearchFiltersIcon {...searchInputs}/>
            <SearchSide {...searchInputs}/>
            { showMap && <SearchMap {...mapData}/> }
            { showMap && <SearchFreeText {...freeTextInput}/> }
        </div>
    </>
    
  )
}

export default Search