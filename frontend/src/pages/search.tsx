import React, { useState } from 'react'
import Search from '@/components/Search'
import { ISearchValue } from '@/components/Search/ISearch';

const search = () => {

  const [value, setValue] = useState('');

  // Preserving input values on side bar close
  const searchValue: ISearchValue = {
    value: value,
    setValue: setValue
  }

  return (
      <Search {...searchValue}/>
  )
}

export default search