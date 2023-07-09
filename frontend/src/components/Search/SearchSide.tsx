import React from 'react'
import { ISearchInputProps, ISearchInputs, ISearchFreeTextInputProps } from './ISearch'
import SearchInput from './SearchInput';
import SearchName from './SearchName';
import SearchRadius from './SearchRadius';
import SearchSideFreeText from './SearchSideFreeText';
import useFindKeywords from './useFindKeywords';
import useFindCategories from './useFindCategories';
import useLogged from '../NavBar/useLogged';
import SearchNoFavourites from './SearchNoFavourites';
import SearchFavourites from './SearchFavourites';

const SearchSide = (props: ISearchInputs) => {

    const {
        open,
        data,
        location,
        showMap,
        results
    } = props;
    const { searchData } = data;
    const {
        freeText,
        buildingType,
        keyword
    } = searchData;

    const { keywords } = useFindKeywords();
    const { categories } = useFindCategories();
    const { isLogged } = useLogged();

    const freeTextInput: ISearchFreeTextInputProps = {
        data: data,
        value: freeText,
        name: 'freeText',
        label: 'Ελεύθερη Αναζήτηση'
    }

    // Building types are db's categories and want to return the ids
    const buidlingTypeInput: ISearchInputProps = {
        data: data,
        value: buildingType,
        name: 'buildingType',
        label: 'Τύπος Κτιρίου',
        dataList: categories
    }

    // Categories are db's keywords and want to return the names
    const keywordInput: ISearchInputProps = {
        data: data,
        value: keyword,
        name: 'keyword',
        label: 'Κατηγορίες',
        dataList: keywords
    }

  return (
    <>
        {
            open &&
            <div className='h-[100%] w-[100%] bg-sky-800 border-4 border-orange-300 flex flex-col lg:w-[30%] xl:w-[25%] 2xl:w-[20%]'>
                <div className='w-[100%] h-[100%] flex flex-col mt-16 last:mb-4 lg:mt-0'>
                    { !showMap && <SearchSideFreeText {...freeTextInput}/> }
                    <SearchInput {...buidlingTypeInput}/>
                    <SearchInput {...keywordInput}/>
                    <SearchName {...location}/>
                    <SearchRadius {...location}/>
                    {
                        isLogged ?  
                        <SearchFavourites {...props}/> :
                        <SearchNoFavourites/>
                    }
                </div>
            </div>
        }
    </>
    
  )
}

export default SearchSide