import React, { useState, useEffect } from 'react'
import Search from '@/components/Search'
import { ISearchData, ISearchPoi, ISearchPoiNumbers } from '@/components/Search/ISearch';
import { INavMenuProps } from '@/components/NavBar/Inav';

const search = (props: INavMenuProps) => {

  const { setNavbarProps } = props;

  useEffect(() => {
    setNavbarProps({
      menuColor: 'black'
    });
  },[])

  // Preserving input values on side bar close
  const [searchData, setSearchData] = useState({
    freeText: '',
    buildingType: '',
    keyword: '',
  });

  const handleInputChange = (key: string, value: string) => {
    setSearchData((prevData) => ({
      ...prevData,
      [key]: value,
    }));
  };
  
  const [poiName, setPoiName] = useState('-');
  const [poiNumbers, setPoiNumbers] = useState<ISearchPoiNumbers>({
    lat: 37.98856735,
    lon: 23.72533417,
    radius: 0
    
  })

  const handlePoiNumbersChange = (key: keyof ISearchPoiNumbers, value: number) => {
    setPoiNumbers(prevState => ({
      ...prevState,
      [key]: value,
    }));
  };

  const poiState: ISearchPoi = {
    selectedName: poiName,
    setSelectedName: setPoiName,
    numbers: poiNumbers,
    setNumbers: handlePoiNumbersChange
  }

  const searchValues: ISearchData = {
    searchData: searchData,
    setSearchData: setSearchData,
    handleInputChange: handleInputChange,
    location: poiState
  }

  return (
      <Search {...searchValues}/>
  )
}

export default search