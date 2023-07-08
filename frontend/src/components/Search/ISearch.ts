import {Dispatch, SetStateAction} from 'react'

export interface ISearchState {
    freeText: string;
    buildingType: string;
    keyword: string;
}

export interface ISearchPoiNumbers {
    lon: number,
    lat: number,
    radius: number,
}

export interface ISearchPoiName {
    selectedName: string,
    setSelectedName: Dispatch<SetStateAction<string>>
}

export interface ISearchPoi {
    selectedName: string,
    setSelectedName: Dispatch<SetStateAction<string>>,
    numbers: ISearchPoiNumbers,
    setNumbers: (key: keyof ISearchPoiNumbers, value: number) => void;
}

export interface IPoiResult {
    id: number,
    name: string,
    description?: string,
    latitude: number,
    longitude: number
}

export interface ISearchMap {
    search: ISearchPoi,
    results: IPoiResult[]
}

export interface ISearchData {
    searchData: ISearchState;
    setSearchData: Dispatch<React.SetStateAction<ISearchState>>;
    handleInputChange: (key: string, value: string) => void;
    location: ISearchPoi
}

export interface ISearchInputs {
    open: boolean,
    setOpen: Dispatch<SetStateAction<boolean>>,
    isClicked: boolean,
    setIsClicked: Dispatch<SetStateAction<boolean>>,
    data: ISearchData,
    location: ISearchPoi,
    showMap: boolean
}

export interface IDataList {
    id: number,
    name: string
}

export interface ISearchInputProps {
    data: ISearchData,
    value: string,
    name: string,
    label: string,
    dataList: IDataList[]
}

export interface ISearchFreeTextInputProps {
    data: ISearchData,
    value: string,
    name: string,
    label: string,
}

export interface IUseFilter {
    isClicked: boolean,
    setIsClicked: Dispatch<SetStateAction<boolean>>
}
