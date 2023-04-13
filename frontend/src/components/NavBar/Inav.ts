import {Dispatch, SetStateAction} from 'react'

export interface INavMenu {
    open: boolean,
    setOpen: Dispatch<SetStateAction<boolean>>
}

export interface INavLink {
    link: string,
    text: string
}