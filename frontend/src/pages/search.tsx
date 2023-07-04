import React, { useState, useEffect } from 'react'
import Search from '@/components/Search'
import { ISearchData } from '@/components/Search/ISearch';
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

  const searchValues: ISearchData = {
    searchData: searchData,
    setSearchData: setSearchData,
    handleInputChange: handleInputChange
  }

  return (
      <Search {...searchValues}/>
  )
}

export default search