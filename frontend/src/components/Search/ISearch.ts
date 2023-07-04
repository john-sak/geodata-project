import {Dispatch, SetStateAction} from 'react'

export interface ISearchState {
    freeText: string;
    buildingType: string;
    keyword: string;
}

export interface ISearchData {
    searchData: ISearchState;
    setSearchData: React.Dispatch<React.SetStateAction<ISearchState>>;
    handleInputChange: (key: string, value: string) => void;
}

export interface ISearchRadius {
    radiusValue: number,
    setRadiusValue: Dispatch<SetStateAction<number>>
}

export interface ISearchInputs {
    open: boolean,
    setOpen: Dispatch<SetStateAction<boolean>>,
    isClicked: boolean,
    setIsClicked: Dispatch<SetStateAction<boolean>>,
    data: ISearchData,
    radius: ISearchRadius,
    showMap: boolean
}

export interface ISearchInputProps {
    data: ISearchData,
    value: string,
    name: string,
    label: string
}

export interface IUseFilter {
    isClicked: boolean,
    setIsClicked: Dispatch<SetStateAction<boolean>>
}
