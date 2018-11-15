export class Item {
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
}