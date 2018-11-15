import { Deserializable } from "../interfaces/deserializable-interface";

export class Item implements Deserializable {
    
    itemID?: number;
    dateReceived?: Date;
    itemName: string;
    cost: number;
    description?: string;
    itemUrl?: string;
    orderID: number;
    returnRequestedDate?: Date;
    returnShippedDate?: Date;
    refundReceivedDate?: Date;
    notes?: string;

    deserialize(input: any): this {
        Object.assign(this, input);
        return this;
    }
}