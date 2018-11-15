import { Deserializable } from "../interfaces/deserializable-interface";

export class ShopAccount implements Deserializable {
    
    shopID?: number;
    shopName: string;
    registeredID: string;
    password: string;
    shopUrl?: string;
    registeredDate?: Date;
    emailID: number;
    phone?: string;
    address?: string;
    paymentMethodID: number;
    notes?: string;

    deserialize(input: any): this {
        Object.assign(this, input);
        return this;
    }
}