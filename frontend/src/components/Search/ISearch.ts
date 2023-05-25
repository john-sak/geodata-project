import {Dispatch, SetStateAction} from 'react'

export interface ISearchFilter {
    open: boolean,
    setOpen: Dispatch<SetStateAction<boolean>>
    value: string,
    setValue: Dispatch<SetStateAction<string>>
}

export interface ISearchValue {
    value: string,
    setValue: Dispatch<SetStateAction<string>>
}